@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
<header>
    <p>
        <a href="/">Home</a>
        <a href="/users">Users</a>
    </p>
</header>
${content}
<footer><p>I am footer</p></footer>
</body>
</html>