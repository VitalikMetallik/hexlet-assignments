@import exercise.dto.users.UserPage
@param UserPage page

<main>
    <h1>${page.getUser().getFirstName() + " " + page.getUser().getLastName()}</h1>
    <p>${"Email: " + page.getUser().getEmail()}</p>
</main>