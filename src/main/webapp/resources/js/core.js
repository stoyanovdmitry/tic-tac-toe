var pathname = window.location.pathname;    //relative path of URL

// player id
var player;
setPlayer();

var grid = new Array(9);   //table array

function step(spaceNumber) {

    if (grid[spaceNumber] !== undefined) return false;
    requestToServer(spaceNumber, player);
}

function setPlayer() {

    $.ajax({
        type: 'GET',
        url: pathname,
        data: 'addPlayer',
        success: function (response) {
            setPlayerID(response);
        },
        error: function (err) {
            alert('ERROR' + "\n" + err.message)
        }
    });

    function setPlayerID(playerID) {

        player = playerID;

        if (playerID !== 0)
            $('#playerID').text('Your are Player ' + player);
        else
            $('#playerID').text('Your are watcher');
    }
}

function requestToServer(position, id) {

    $.ajax({
        type: 'GET',
        url: pathname + '/set',
        data: {
            position: position,
            id: id
        },
        success: function (response) {
            setClasses(response)
        },
        error: function (err) {
            alert('ERROR' + "\n" + err.message)
        }
    });
}

function setClasses(responseGrid) {

    for (var i = 0; i < grid.length; i++) {

        var figure = $('#' + i).children();

        if (responseGrid[i] === 1) {
            grid[i] = 1;
            figure.addClass('x');
        } else if (responseGrid[i] === 2) {
            grid[i] = 2;
            figure.addClass('o');
        }
    }
}