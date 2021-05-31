<!DOCTYPE html>
<html>
<head>
    <title>User list</title>
    <meta name="layout" content="headerFooter"/>
    <asset:stylesheet src="application.css"/>
    <g:javascript library="jquery" plugin='jquery'/>

    <script type="text/javascript">
      function sendSearchDataToController() {

        var formData = {
          userName: $('#userName').val(),
          pokemonName: $('#pokemonName').val(),
          from: $('#from').val(),
          to: $('#to').val()
        };

        $.ajax({
          url: "${g.createLink( controller: 'user', action:'search')}",
          type: "post",
          data: formData,
          success: function (data) {
            console.log('data', data);

            $('#resultDiv').html(data)
          },
          error: function (data) {
            console.log('Error', data);
            $("#resultDiv").addClass('alert alert-danger').append('Error saving event')
          }
        });
      }
    </script>
</head>

<body onload="">
<div class="content scaffold-list">

    <form method="post">
        <input value="${params.userName}" name="userName" id="userName">
        <input value="${params.pokemonName}" name="pokemonName" id="pokemonName">
        <input value="${params.from}" name="from" id="from">
        <input value="${params.to}" name="to" id="to">

        <button type="button" onclick="sendSearchDataToController()">Search</button>
    </form>

    <div id="resultDiv">
        <g:render template="usersTemplate" model="users"/>
    </div>
</div>
</body>
</html>