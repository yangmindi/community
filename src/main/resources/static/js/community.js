function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    $.ajax({
        type:"post",
        url:"/comment",
        contentType:'application/json',
        data:JSON.stringify({
            "parentId":questionId,
            "content":content,
            "type":1
        }),
        dataType:"json",
        success:function (response) {
            if(response.code == 200){
                $("#comment_section").hide();
            }else {
                //检查是否是没登录
                if(response.code == 2003){
                    var isAccepted = confirm(response.message);
                    if(isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=Iv1.c7e6499ca87e17c5&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                    }
                }else {
                    alert(response.message);
                }
            }
            console.log(response);
        }
    })
}