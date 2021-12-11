//카테고리 선택
$('.menuWrap>article:eq(1)').css({zIndex:1})

$('#category p').on('click',function(e){
    let num=$(this).index()-1
    $(this).parent().siblings('article').hide()
    $(this).parent().siblings('article:eq('+num+')').show()
    e.preventDefault()
})


//카테고리의 각 메뉴 선택 시 ordered칸에 append