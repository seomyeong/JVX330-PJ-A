for(let i = 0 ; i < 50 ; i++){
    
	let randTop =  Math.floor(Math.random() * (-window.innerHeight));
    let randLeft = Math.floor(Math.random() * window.innerWidth);
	let size = Math.ceil(Math.random()*10)+20;  
	
	let newDiv = document.createElement('div');
	
	newDiv.className = 'snowWrap';
	newDiv.style.top = randTop+'px';
    newDiv.style.left = randLeft+'px';
    newDiv.style.width = size+'px'
    newDiv.style.height = size+'px'
	

    $('body').prepend(newDiv);
 	newDiv.style.animationDuration = (Math.ceil(Math.random()*10)+5) + "s";
}