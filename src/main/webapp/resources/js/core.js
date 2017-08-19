var pathname = window.location.pathname;    //relative path of URL

// player id
var player;
setPlayer();

var grid = new Array(9);   //table array

var playerStep = 1; //player who's due next step

var isGameOver = false;


function step(spaceNumber) {

    // alert(player + ' - ' + playerStep)
    if (grid[spaceNumber] !== undefined || playerStep !== player) return false;

    if (playerStep === 1) playerStep++;
    else if (playerStep === 2) playerStep--;

    requestToServer(spaceNumber, player);
}

function setPlayerStep(player) {
    playerStep = player;
    if (player === 3 || player === 4) {
        checkGameOver();
    }
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

function setGameOverClasses(row) {

    for (var i = 0; i < row.length; i++) {
        $('#' + row[i]).children().addClass('red');
    }
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
            alert('ERROR' + "\n" + err.message);
        }
    });

    function setPlayerID(playerID) {

        player = playerID;

        if (playerID !== 0)
            $('#playerID').text('You are Player ' + player);
        else
            $('#playerID').text('You are watcher');
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
            alert('ERROR' + "\n" + err.message);
        }
    });
}


function checkGameOver() {

    isGameOver = true;

    $.ajax({
        type: 'GET',
        url: pathname,
        data: 'checkGameOver',
        success: function (response) {
            setGameOverClasses(response.winningRow);
        },
        error: function (err) {
            alert('ERROR' + "\n" + err.message);
        }
    });
}

(function checkGame() {
    if (!isGameOver)
        $.ajax({
            type: 'GET',
            url: pathname,
            data: 'checkGame',
            success: function (response) {
                setClasses(response.grid);
                setPlayerStep(response.playerStep);
            },
            complete: function () {
                // Schedule the next request when the current one's complete
                setTimeout(checkGame, 1000);
            },
            error: function (err) {
                alert('ERROR checkGame' + "\n" + err.message);
            }
        });
})();