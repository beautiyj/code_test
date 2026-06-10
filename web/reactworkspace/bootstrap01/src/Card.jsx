const Card = () => {

    return (
    <div className="container mt-5">
      <div className="card shadow" style={{width: "20rem"}}>
        <img src="https://picsum.photos/300/200" className="card-img-top" title="sample" />
        <div className="card-body">
          <h5 className="card-title">React Bootstrap Card</h5>
          <p className="card-text">카드 UI 예제입니다.</p>
          <button className="btn btn-primary">상세보기</button>
        </div>
      </div>
    </div>
  );
};

export default Card;
