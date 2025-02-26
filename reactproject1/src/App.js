import './App.css';
import { useState } from "react";
import MyH2 from "./h2";
import TodoList from "./component/TodoList";
import SelectComponent from "./component/SelectComponent";

function App() {
    const [changeColor, setChangeColor] = useState("red");

    const colors = {
        "red": "빨강",
        "orange": "주황",
        "yellow": "노랑",
        "green": "초록",
        "blue": "파랑",
        "navy": "남색",
        "purple": "보라"
    };

    return (
        <div>
            <MyH2 text="Hello, React!" color={changeColor} />

            <SelectComponent
                items={colors}
                onColorChange={setChangeColor}
            />

            <TodoList />
        </div>
    );
}

export default App;
