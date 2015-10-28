<html>
    <head>
        <meta charset="UTF-8">
        <title>Search for movie</title>
        <link rel="shortcut icon" href="favicon.ico" mce_href="favicon.ico" type="image/x-icon">
    </head>
    <body>
        {include file="header.tpl"}
        <h1>{$name}</h1>
        <h2>{$cat}</h2><br>
        <h3>INFO</h3>
        <p>{$info}</p><br>
        <h3>Supplementary data</h3><br>
        
        {for $i = 0 to $num}
            <img src='{$pics[$i]}'><br>
            <p>{$comms[$i]}</p>
            <hr>
        {/for}
    </body>
</html>