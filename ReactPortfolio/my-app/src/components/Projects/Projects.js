import { Container, Row, Col } from "react-bootstrap";
import Project from "./Project";

const Projects = () => {
  const projects = [
    {
      name: "BoardingPass",
      description:
        "A JavaFX Project to recreate an airline fight registration and boarding pass Generator",
      link: "https://github.com/Slavinn/BoardingPass",
      image: "",
    },
    {
      name: "HangMan Game",
      description: "A simple JavaFX HangMan Game",
      link: "https://github.com/Slavinn/GenSpark/tree/main/HangMan2.0",
      image: "",
    },
    {
      name: "Human vs Goblins Game",
      description: "OOP Java game using JavaFX",
      link: "https://github.com/Slavinn/GenSpark/tree/main/guiHvG",
      image: "",
    },
    {
      name: "CustomerForm",
      description: "Raw HTML & CSS user Form with JavaScript validation",
      link: "https://github.com/Slavinn/GenSpark/tree/main/CustomerForm",
      image:
        "https://github.com/Slavinn/GenSpark/blob/main/CustomerForm/CustomerForm.png",
    },
  ];

  const projectsList = projects.map((project) => {
    return (
      <Col key={project.name} className=" p-3 justify-content-center">
        <Project
          name={project.name}
          description={project.description}
          link={project.link}
        />
      </Col>
    );
  });

  return (
    <Container fluid="sm">
      <Row>{projectsList}</Row>
    </Container>
  );
};

export default Projects;
