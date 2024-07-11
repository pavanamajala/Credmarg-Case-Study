import React from 'react';
import './InputBoxWithLabel.css';

const InputBoxWithLabel = ({ label, value, onChange }) => {
  return (
    <div className="input-box">
      <label className="input-label">{label}</label>
      <input
        type="text"
        className="input-field"
        value={value}
        onChange={onChange}
      />
    </div>
  );
};

export default InputBoxWithLabel;
