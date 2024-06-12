@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <div>
        <h3>Name</h3>
        <p>${page.getPost().getName()}</p>
        <h3>Post</h3>
        <p>${page.getPost().getBody()}</p>
        <a href="${NamedRoutes.postsPath()}">All posts</a>
    </div>
`
)