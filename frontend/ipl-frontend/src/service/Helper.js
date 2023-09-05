
export const HelperFunction = async (field) => {
  const response = await fetch(`http://localhost:8080/teamName/${field}`);
  const data = await response.json()

  return data;
}
