 mouseHouve = function (button)
{
	var button = document.querySelector('button');
	button.element.style.backgroundColor ='pink';
}

onload = function()
{
        
        mouseHouve.addEventListener("mouseouver",mouseHouver,false);
       
}
window.onload("load", onload, false);