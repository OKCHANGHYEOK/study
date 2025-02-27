function InputComponent(props) {
    return (
        <div>
            <input type={props.type}
                   width={props.width}
                   height={props.height}
                   placeholder={props.placeholder}
                   style={props.style}/>
        </div>
    );
}

export default InputComponent;