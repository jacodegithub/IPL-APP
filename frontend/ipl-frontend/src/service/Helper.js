
export const BASE_URL = 'http://localhost:8080/teamName/'

export const HelperFunction = async (field) => {
  const response = await fetch(BASE_URL+`${field}`);
  const data = await response.json()

  return data;
}

export const HelperFunctionForAllMatches = async (field) => {
  const response = await fetch(BASE_URL+`matches/${field}`);
  const data = await response.json();

  return data;
}
