import { GET, POST, PUT, DELETE }  from "./fetch-action";

interface PostArticle {
  id? : string,
  title: string,
  body: string
}

const createTokenHeader = (token:string) => {
  return {
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + token
    }
  }
}

export const getArticleList = () => {
  const URL = 'api/user/article/all/';
  const response = GET(URL, {});
  return response;
};

export const getPageList = (param:string) => {
  const URL = '/api/user/article/page?page=' + param;
  const response = GET(URL, {});
  return response;
}

export const getOneArticle = (param:string, token?:string) => {
  const URL= 'api/user/article/one?id=' + param;
  if (!token) {
    const response = GET(URL, {});
    return response;
  } else {
    const response = GET(URL, createTokenHeader(token));
    return response;
  }
};

export const makeArticle = (token:string, article:PostArticle) => {
  const URL = 'api/user/article/write';
  const response = POST(URL, article, createTokenHeader(token));
  return response;
};

export const getChangeArticle = (token:string, param:string) => {
  const URL = 'api/user/article/change?id=' + param;
  const response = GET(URL, createTokenHeader(token));
  return response;
};

export const changeArticle = (token:string, article:PostArticle) => {
  const URL = 'api/user/article/';
  const response = PUT(URL, article, createTokenHeader(token));
  return response;
};

export const deleteArticle = (token:string, param:string) => {
  const URL = 'api/user/article/one?id=' + param;
  const response = DELETE(URL, createTokenHeader(token));
  return response;
}