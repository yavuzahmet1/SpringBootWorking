import React from "react";

const Input = (props) => {
    const { label, error, name, onChange } = props
    const className = error ? 'form-control is-invalid' : 'form-control';
    return (
        <div className="mb-3">
            <label>{label}</label>
            <input className={className} name={name} onChange={onChange} />
            <div className="invalid-feedback">{error}</div>
        </div>
    )
}

export default Input;