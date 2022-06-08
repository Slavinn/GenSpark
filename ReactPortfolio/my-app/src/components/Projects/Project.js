import { Card, Button } from "react-bootstrap";

const Project = (props) => {
  return (
    <Card style={{ width: "18rem" }}>
      <Card.Img variant="top" src={props.image} />
      <Card.Body>
        <Card.Title>{props.name}</Card.Title>
        <Card.Text>{props.description}</Card.Text>
        <Button variant="primary" href={props.link}>
          GitHub Link
        </Button>
      </Card.Body>
    </Card>
  );
};

export default Project;
