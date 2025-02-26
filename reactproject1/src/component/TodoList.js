import React, {useState} from "react";

function TodoList() {
    const [todoList, setTodoList] = useState([]); // 할일 목록 저장
    const [newTodo, setNewTodo] = useState(""); // 새로 추가할 목록 저장
    const [editingIndex, setEditingIndex] = useState(null); // 수정 중인 항목의 인덱스
    const [editingTodo, setEditingTodo] = useState(""); // 수정 중인 할일의 값

// 새로운 할일 추가하는 함수
    const addNewTodo = () => {
        if(newTodo.trim() !== "") {
            setTodoList([...todoList, newTodo])
            setNewTodo("") // 입력 필드를 비워줌
        }
    }

// 할일 삭제하는 함수
    const deleteTodo = (index) => {
        const updatedList = [
            ...todoList.slice(0, index),
            ...todoList.slice(index + 1)
        ]
        setTodoList(updatedList);
    }

// 수정 시작
    const startEditing = (index) => {
        setEditingIndex(index);
        setEditingTodo(todoList[index]);
    }

// 수정 완료
    const finishEditing = () => {
        const updatedList = [...todoList];
        updatedList[editingIndex] = editingTodo;
        setTodoList(updatedList);
        setEditingIndex(null); // 수정 모드 종료
        setEditingTodo(""); // 수정된 값 초기화
    }

    return (
        <div>
            <h1>To Do List</h1>
            <input
                type="text"
                value={newTodo}
                onChange={(e) => setNewTodo(e.target.value)}
            />
            <button onClick={addNewTodo}>추가</button>

            <ul>
                {todoList.map((todo, index) => (
                    <li key={index}>
                        {editingIndex === index ? (
                            <>
                                <input
                                    type="text"
                                    value={editingTodo}
                                    onChange={(e) => setEditingTodo(e.target.value)}
                                />
                                <button onClick={finishEditing}>수정완료</button>
                            </>
                        ) : (
                            <>
                                {todo}
                                <button onClick={() => deleteTodo(index)}>삭제</button>
                                <button onClick={() => startEditing(index)}>수정</button>
                            </>
                        )}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default TodoList;