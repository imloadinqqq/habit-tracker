import { render, screen } from '@testing-library/react';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});

test('displays habits', () => {
  render(<App />);
  const listElement = screen.get  () {
    
  } {
    
  }(/Something here/i)
  expect(listElement).toBeInTheDocument();
});
