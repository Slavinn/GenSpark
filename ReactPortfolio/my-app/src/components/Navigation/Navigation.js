import { Nav, Navbar, Container } from "react-bootstrap";

const Navigation = () => {
  return (
    <Navbar bg="light" variant="light">
      <Container>
        <Navbar.Brand href="#home">Slavinn</Navbar.Brand>
        <Nav className="me-auto">
          <Nav.Link href="#home">Home</Nav.Link>
          <Nav.Link href="#projects">GitHub</Nav.Link>
          <Nav.Link href="#">Contact</Nav.Link>
        </Nav>
      </Container>
    </Navbar>
  );
};

export default Navigation;
