package com.javaaround
import com.javaaround.usermanagement.User;
class HelloworldController {
	
    def index() { 
    	//render "Hello World"; //render directly
    	//render (view: "greet"); // render specific view
    	User user = new User(userId: 'IT007', fullName:'Md.Shamim Miah', address:'Tangail')
        
        /*if register view name
        def map = [ user:user ] 
    	render(view: "display", model: map)
    	*/
        
        //save into db
        user.save()
        //read
        User u = User.get(1)

        //update
        u.fullName="update"
        u.save()

        //delete
        //u.delete()

        //no of record
        println(u.count)


    	def userList = []
    	userList << new User(userId: 'IT007', fullName:'Md.Shamim Miah', address:'Tangail')
    	userList << new User(userId: 'IT008', fullName:'Md.Shohel', address:'Feni')
    	userList << new User(userId: 'IT0010', fullName:'Md.Mozzammel', address:'Dhaka')

    	// set view model
    	[ user:user,userList:userList ] 
    }
    
}
