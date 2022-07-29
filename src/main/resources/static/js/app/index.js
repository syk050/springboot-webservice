const main = {
    init: function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });
    },
    save: function () {
        const data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: "POST",
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(() => {
            alert('글이 등록되었습니다.');
            window.location.href= '/';
        }).fail((error) => {
            alert(JSON.stringify(error));
        });
    },
    update: () => {
        const data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        const id = $('#id').val();

        $.ajax({
            type: 'put',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(() => {
            alert('글이 수정되었습니다.');
            window.location.href = '/'
        }).fail((error) => {
            alert(JSON.stringify(error));
        });
    },
    delete: () => {
        const id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(() => {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail((error) => {
            alert(JSON.stringify(error));
        });
    }

};

main.init();

/*
브라우저의 스코프는 공용 공간으로 쓰이기 떄문에
나중에 로딩된 js의 init, save가 먼저 로딩된 js의 function을 덮어쓰게 됨
그렇기 때문에 main이란 객체를 만들어 해당 객체에서 필요한 모든 finction을 선언하는 것
*/
