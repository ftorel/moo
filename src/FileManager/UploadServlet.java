package FileManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;

import DataBase.FileTable;
import Utils.Constant;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 20; // 20MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  if (!ServletFileUpload.isMultipartContent(request)) {
	            // if not, we stop here
	            PrintWriter writer = response.getWriter();
	            writer.println("Error: Form must has enctype=multipart/form-data.");
	            writer.flush();
	            return;
	        }
	 
		  	String filename = request.getParameter("fileName");
		  
	        // configures upload settings
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        // sets memory threshold - beyond which files are stored in disk
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        // sets temporary location to store files
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	        ServletFileUpload upload = new ServletFileUpload(factory);
	         
	        // sets maximum size of upload file
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	         
	        // sets maximum size of request (include file + form data)
	        upload.setSizeMax(MAX_REQUEST_SIZE);
	 
	        // constructs the directory path to store upload file
	        // this path is relative to application's directory
	        String uploadPath = getServletContext().getRealPath("")
	                + File.separator + UPLOAD_DIRECTORY;
	         
	        // creates the directory if it does not exist
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	        try {
	            // parses the request's content to extract file data
	            //@SuppressWarnings("unchecked")
	            List<FileItem> formItems = upload.parseRequest(request);
	 
	            if (formItems != null && formItems.size() > 0) {
	                // iterates over form's fields
	                for (FileItem item : formItems) {
	                    // processes only fields that are not form fields
	           	
	                    if (!item.isFormField()) {
	                        String fileName = new File(item.getName()).getName().replaceAll("[^a-zA-Z0-9.-]", "");
	                        
	                        String filePath = uploadPath + File.separator + fileName;
	                        filePath = filePath.replace(" ","_");
	                        
	                        if(fileName.length() == 0){
	                        	this.finished(request, response);
	                        	return;
	                        }
	                        
	                        HttpSession httpSession = request.getSession();
	                        Integer teamId = (Integer) httpSession.getAttribute( Constant.TAG_TEAM_ID );
	                        String userMail = (String) httpSession.getAttribute( Constant.TAG_MAIL );
	                        if(FileTable.addFile(fileName, filePath, userMail,teamId)){
	                        	  File storeFile = new File(filePath);
	  	                        // saves the file on disk
	  	                        item.write(storeFile);
	                        }
	                    }
	                }
	            }
	        } catch (Exception ex) {
	        	
	        }
	    	this.finished(request,response);
	    }
	
	private void finished(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("DocumentServlet");
		if (dispatcher != null){
    		dispatcher.forward(request, response);
    	}
	}

}
