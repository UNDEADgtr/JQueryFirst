$('#buttonModelShow').click(function () {
    $.getJSON('model.json', {}, function (json) {
        $('#model').html('');
        $('#model').append('model: ' + json.car.model + '&lt;br/&gt;').
            append('color: ' + json.car.color + '&lt;br/&gt;').
            append('cost: ' + json.car.cost);
    });
    $('#model').fadeIn();
    return false;
});

$('#buttonModelHide').click(function () {
    $('#model').fadeOut();
    return false;
});

$('#buttonDataShow').click(function () {
    $.getJSON('data.json', function (data) {
        var items = [];
        $.each(data, function (key, val) {
            $.each(val, function (key1, val1) {
                items.push(key1 + ": " + val1 + '&lt;br/&gt;');
            });
        });
        $('#data').html('');
        $('#data').append(items.join(' '));
    });
    $('#data').fadeIn();
});

$('#buttonDataHide').click(function () {
    $('#data').fadeOut();
    return false;
});

$('#saveData').click(
    function () {
        #{main.writeJson()}
    }
);
