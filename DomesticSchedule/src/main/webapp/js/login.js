$(document).ready(function() {

	// フォーム要素を取得
    const form = document.getElementById('myForm');
    const contextPath = '/DomesticSchedule';

    function loginAction(){
		form.action = contextPath+'/loginAuthorize';
		form.method = 'post';
		form.submit();
	}

	function createAction(){
		form.action = contextPath+'/page/regist.jsp';
		form.method = 'post';
		form.submit();
	}

	// ボタンのクリックイベントを設定
    $('#loginButton').click(function() {
        loginAction();
    });

    $('#createButton').click(function() {
        createAction();
    });
});
