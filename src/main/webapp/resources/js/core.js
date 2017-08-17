var player = Math.round(Math.random() + 1);   //random choosing of player who will start

var grid = new Array(9);   //table array

function set(spaceNumber) {

    if (grid[spaceNumber] !== undefined) return false;

    requestToServer(spaceNumber, player);
}

function requestToServer(position, id) {

    $.ajax({
        type: 'GET',
        url: '/set',
        data: {
            position: position,
            id: id
        },
        success: function (response) {
            setClasses(response)
        },
        error: function (err) {
            alert(err.message)
        }
    });
}

function setClasses(responseGrid) {

    for (var i = 0; i < grid.length; i++) {

        var figure = $('#' + i).children();

        if (responseGrid[i] === 1) {
            grid[i] = 1;
            figure.addClass('x');
            player++;
        } else if (responseGrid[i] === 2) {
            grid[i] = 2;
            figure.addClass('o');
            player--;
        }
    }
}