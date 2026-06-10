const Button = () => {

  const clickBtn = () => {
    alert("버튼 클릭!");
  };

  return (
    <div className="flex justify-center items-center h-screen bg-gray-100">
      <button onClick={clickBtn} className="bg-blue-500 text-white px-6 py-3 rounded-lg hover:bg-blue-700">
        클릭하세요
      </button>
    </div>
  );
}

export default Button;
