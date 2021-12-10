let productSelectList = document.querySelector('#productSelectList');
let productSelectNum = document.querySelector('#productSelectNum');


productSelectList.addEventListener('change', (event) => {
	productSelectNum.innerHTML = productSelectList.value;
});