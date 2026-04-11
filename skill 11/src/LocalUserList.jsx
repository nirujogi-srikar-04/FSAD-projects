import { useState, useEffect } from "react";

function LocalUserList() {

    const [users, setUsers] = useState([]);

    useEffect(() => {
        fetch("/users.json")
            .then(res => res.json())
            .then(data => setUsers(data));
    }, []);

    return (
        <div>
            <h2>Local Users</h2>

            <table border="1">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                </tr>

                {users.map(u => (
                    <tr key={u.id}>
                        <td>{u.name}</td>
                        <td>{u.email}</td>
                        <td>{u.phone}</td>
                    </tr>
                ))}
            </table>
        </div>
    );
}

export default LocalUserList;