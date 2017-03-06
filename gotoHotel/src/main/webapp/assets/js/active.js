$(function(){
	
	//solving active menu problem
	switch(menu){
		case'About':
		$('#aboutUs').addClass('active');
		break;
	case'Contact':
		$('#contactUs').addClass('active');
		break;
	case'Login':
		$('#login').addClass('active');
		break;
	case'Services':
		$('#productDescription').addClass('active');
		break;
	case'Register':
		$('#register').addClass('active');
		break;
	case'Category':
		$('#category').addClass('active');
		break;
	case'Admin':
		$('#admin').addClass('active');
		break;
	default:
		$('#index').addClass('active');
		
	}
	
	
	
})