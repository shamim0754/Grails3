package com.javaaround
import com.javaaround.usermanagement.User;
class HelloworldController {
	// the framework will automatically look for a GSP file 
    //located in a folder with the same method name as the controller under views 
    //since there is render.
    def index() { 
    	//render "Hello World"; //render directly
    	//render (view: "greet"); // render specific view
    	User user = new User(userId: 'IT007', fullName:'Md.Shamim Miah', address:'Tangail')
        // set view model

        //if register view name
        //def map = [ user:user ] 
    	//render(view: "display", model: map)
    	def userList = []
    	userList << new User(userId: 'IT007', fullName:'Md.Shamim Miah', address:'Tangail')
    	userList << new User(userId: 'IT008', fullName:'Md.dd', address:'dgggd')
    	userList << new User(userId: 'IT0010', fullName:'Md.dd', address:'ad')

    	[ user:user,userList:userList ] 
    }
    
}
