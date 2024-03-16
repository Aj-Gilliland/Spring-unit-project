<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring-unit-project</title>
    <style>
        /* Example CSS for column layout */
        .column-container {
            display: flex;
            justify-content: space-between;
        }
        
        .column {
            flex: 1;
            padding: 10px;
            /* Add more styling here */
        }

        .license-img {
            width: 4%;
            background-color: white;
        }
    </style>
</head>
<body>
    <div align="center">
        <h1>Messenger.Nerd</h1>

        <h2>DESCRIPTION</h2>
        <p>The purpose is to provide a secure way to store messages. It is cloud based, making it more secure than a local service.</p>

        <h2>KEY FEATURES:</h2>
        <div class="column-container">
            <div class="column">
                <h3>Set up dependent:</h3>
                <ol>
                    <li>Store User History</li>
                    <li>View Messages</li>
                    <li>View all Chat Room</li>
                    <li>Delete Messages</li>
                    <li>Delete Chat Rooms</li>
                    <li>Make Chat Rooms</li>
                </ol>
            </div>
            <div class="column">
                <h3>User:</h3>
                <ol>
                    <li>Make Messages</li>
                    <li>Reply Messages</li>
                    <li>Delete User</li>
                    <li>Make User</li>
                </ol>
            </div>
            <div class="column">
                <h3>Admin:</h3>
                <ol>
                    <li>Can view all users</li>
                </ol>
            </div>
        </div>

        <h2>Inspiration</h2>
        <p>We were inspired by slack and organizations needing a secure way to chat.</p>

        <h2>HOW TO USE Messenger.Nerd</h2>
        <p>To use the application, admin would have to connect to the endpoints. From there, the messages would be stored in the API.</p>

        <h2>LICENSE</h2>
        <img class="license-img" src="copyleft.png" alt="copyleft image">
        <p>copyleft</p>
    </div>
</body>
</html>
