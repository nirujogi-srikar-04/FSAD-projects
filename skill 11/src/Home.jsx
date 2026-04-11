import { useState } from "react";
import LocalUserList from "./LocalUserList";
import UserList from "./UserList";
import FakePostList from "./FakePostList";

function Home() {

    const [page, setPage] = useState("local");

    return (
        <div>

            <button onClick={() => setPage("local")}>Local Users</button>
            <button onClick={() => setPage("api")}>Users API</button>
            <button onClick={() => setPage("posts")}>Fake Posts</button>

            <hr />

            {page === "local" && <LocalUserList />}
            {page === "api" && <UserList />}
            {page === "posts" && <FakePostList />}

        </div>
    );
}

export default Home;