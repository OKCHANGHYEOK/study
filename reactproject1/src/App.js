import logo from './logo.svg';
import './App.css';
import {useState} from "react";
import {getValue} from "@testing-library/user-event/dist/utils";

function App() {

  const [todoList, setTodoList] = useState([]); // 할일 목록 저장
  const [newTodo, setNewTodo] = useState(""); // 새로 추가할 목록 저장

  // 새로운 할일 추가하는 함수
  const addNewTodo = () => {
      if(newTodo.trim() !== "") {
          setTodoList([...todoList, newTodo])
          setNewTodo("") // 입력 필드를 비워줌
      }
  }

  // 할일 삭제하는 함수(slice 사용)
  const deleteTodo = (index) => {
      // 삭제할 데이터를 제외한 새로운 목록 만들기
      const updatedList = [
          ...todoList.slice(0, index), // index 보다 앞에 위치한 할일들을 잘라서 가져옴
          ...todoList.slice(index + 1) // index 보다 뒤에 위치한 할일들을 잘라서 가져옴
      ]
      setTodoList(updatedList);
  }

  return (
    <div>
      <h1>To Do List</h1>
      <input type="text" value={newTodo} onChange={(e)=>{
          // console.log(e);
          // console.log(`newTodo:${newTodo}`);
          setNewTodo(e.target.value);
      }}/>
      <button onClick={addNewTodo}>추가</button>
      <ul>
          {todoList.map((todo, index) => (
              <li key={index}>
                  {todo} <button onClick={() => deleteTodo(index)}>삭제</button>
              </li>
          ))}
      </ul>
    </div>
  );
}

export default App;
