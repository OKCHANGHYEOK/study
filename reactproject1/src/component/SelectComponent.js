import React from "react";

function SelectComponent(props) {
    console.log(props)

    const items = props.items;

    const texts = Object.keys(items);
    const values = Object.values(items);

    return (
        <div>
            <select title="sel_MyH2Color" onChange={(e) => {props.onColorChange(e.target.value)}}>
                {texts.map((txt, index) => (
                    <option key={index} value={txt}>{values[index]}</option>
                ))}
            </select>
        </div>
    );
}

export default SelectComponent;