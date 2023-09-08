
export const BASE_URL = 'http://localhost:8080/teamName'

export const HelperFunction = async (field) => {
  const response = await fetch(BASE_URL+`/${field}`);
  const data = await response.json()

  return data;
}

export const HelperFunctionForAllMatches = async (field) => {
  const response = await fetch(BASE_URL+`/matches/${field}`);
  const data = await response.json();
  return data;
}

export const HelperFunctionGetAllSeasons = async () => {
  const response = await fetch(BASE_URL+`/seasons`);
  const data = await response.json();
  // console.log('helper ->', data)
  return data;
}

export const HelperFunctionToGetMatchesBySeason = async (teamName, first, second) => {
  console.log('data ->', first, second)
  const response = await fetch(BASE_URL+`/season/${teamName}?firstYear=${first}&secondYear=${second}`)
  const data = await response.json();
  
  return data;
}
