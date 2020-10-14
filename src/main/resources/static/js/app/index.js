console.log('hello');
var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            if ($("#d_file").children().length==0){
                alert('상품 이미지를 등록해주세요.');
                return false;
            }
            $("#d_file").children('input').each(function(index,item){
                var fileValue = $(item).val().split("\\");
                var fileName = fileValue[fileValue.length-1]; // 파일명
                console.log(fileName);
                if (!fileName){
                    alert('상품 이미지를 등록해주세요.');
                    return false;
                } else {
                    _this.save();
                }
            });


        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
        console.log('save');
        var formData = new FormData($('#fileForm')[0]);

        $.ajax({
            type: 'POST',
            enctype: 'multipart/form-data', // 필수
            url: '/api/v1/goods',
            data: formData, // 필수
            processData: false, // 필수
            contentType: false, // 필수
            cache: false,
        }).done(function() {
            alert('상품이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var formData = new FormData($('#fileForm')[0]);

        var id = $('#id').val();
        $.ajax({
            type: 'PUT',
            enctype: 'multipart/form-data', // 필수
            url: '/api/v1/goods/'+id,
            data: formData, // 필수
            processData: false, // 필수
            contentType: false, // 필수
            cache: false,
        }).done(function() {
            alert('상품이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        console.log('delete')
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/goods/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('상품이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();