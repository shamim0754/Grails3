package com.javaaround

class HelloworldController {
	// the framework will automatically look for a GSP file 
    //located in a folder with the same method name as the controller under views 
    //since there is render.
    def index() { 
    	//render "Hello World"; //render directly
    	render (view:'greet.gsp'); // render specific view
    }
    
}
