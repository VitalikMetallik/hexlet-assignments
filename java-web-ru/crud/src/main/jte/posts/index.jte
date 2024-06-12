@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    <div>
        <table>
            <th>Name</th>
            <th>Post</th>
            @for (int i = (page.getPage() - 1) * 5; i < (page.getPage() - 1) * 5 + 5; ++i)
                <tr>
                    <td><a href="/posts/${page.getPage() + i}">${page.getPosts().get(i).getName()}</a></td>
                    <td>${page.getPosts().get(i).getBody()}</td>
                </tr>
            @endfor
        </table>
        <nav>
            <ul>
                <li><a href="/posts?page=${page.getPage() - 1}">Previous</a></li>
                <li><a href="/posts?page=${page.getPage()}">${page.getPage()}</a></li>
                <li><a href="/posts?page=${page.getPage() + 1}">Next</a></li>
            </ul>
        </nav>
    </div>
`
)