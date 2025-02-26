import React from 'react';

function MyH2(props) {
    return (
        <h2 style={{color : props.color}}>
            {props.text}
        </h2>
    )
}

export default MyH2;