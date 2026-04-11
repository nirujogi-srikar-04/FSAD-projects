import { useState, useEffect } from "react";
import axios from "axios";

function FakePostList() {

    const [posts, setPosts] = useState([]);

    const loadData = () => {
        axios.get("https://dummyjson.com/posts")
            .then(res => setPosts(res.data.posts));
    };

    useEffect(() => {
        loadData();
    }, []);

    return (
        <div>
            <h2>Fake API Posts</h2>

            <button onClick={loadData}>Refresh</button>

            <ul>
                {posts.slice(0, 10).map(p => (
                    <li key={p.id}>
                        <b>{p.title}</b>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default FakePostList;