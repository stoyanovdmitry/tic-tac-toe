var pathname = window.location.pathname;    //relative path of URL

// player id
var player;
setPlayer();

var grid = new Array(9);   //table array

var playerStep = 1; //player who's due next step

var isGameOver = false;

checkGame();


function setText() {
    if (playerStep === player)
        $('#playerID').text("Your turn");
    else if (playerStep !== player && player !== 0)
        $('#playerID').text("Wait while your opponent walks");
    else
        $('#playerID').text("You are watcher");
}

function step(spaceNumber) {

    // alert(player + ' - ' + playerStep)
    if (grid[spaceNumber] !== undefined || playerStep !== player) return false;

    if (playerStep === 1) playerStep++;
    else if (playerStep === 2) playerStep--;

    setText();

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

function setGameOverText() {
    if (playerStep - 2 === player)
        $('#playerID').text('You Win!');
    else if (playerStep - 2 !== player && player !== 0)
        $('#playerID').text('You Lose');
}

function setGameOverClasses(row) {

    setGameOverText();

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
        // setText();
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

    $.ajax({
        type: 'GET',
        url: pathname,
        data: 'checkGameOver',
        success: function (response) {
            setGameOverClasses(response.winningRow);
        },
        error: function (err) {
            alert('ERROR checkGameOver' + "\n" + err.message);
        }
    });
    checkGame();
    isGameOver = true;
}

function checkGame() {
    if (!isGameOver)
        $.ajax({
            type: 'GET',
            url: pathname,
            data: 'checkGame',
            success: function (response) {
                setClasses(response.grid);
                setPlayerStep(response.playerStep);
                setText();
                setTimeout(checkGame, 250);
            },
            complete: function () {
                // Schedule the next request when the current one's complete
            },
            error: function (err) {
                alert('ERROR checkGame' + "\n" + err.message);
            }
        });
}

$(window).on("unload", function () {
    if (player !== 0)
        $.ajax({
            type: 'GET',
            url: pathname,
            data: 'playerLeft',
            async: false
        })
});