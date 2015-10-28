<html>
    <head>
        <meta charset="UTF-8">
        <title>success</title>
        <link rel="shortcut icon" href="favicon.ico" mce_href="favicon.ico" type="image/x-icon">
    </head>
    <body>
        {include file="header.tpl"}
        <h1>Search movie library by category {$cat}</h1>
        <table border="3">
            <th>Movie</th>
            {foreach item = mvk from = $mvks}
            <tr>
                <td>
                    <a href='SearchResult.php?mvn={$mvk}'>{$mvk}</a>
                </td>
            </tr>
            {/foreach}
        </table>                
    </body>
</html>