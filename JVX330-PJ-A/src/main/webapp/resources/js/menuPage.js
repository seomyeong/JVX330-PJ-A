$('.menuWrap>article:eq(1)').css({zIndex:1})

$('#category p').on('click',function(e){
    let num=$(this).index()-1
    $(this).parent().siblings('article').hide()
    $(this).parent().siblings('article:eq('+num+')').show()
    e.preventDefault()
})