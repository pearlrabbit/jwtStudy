import { Fragment } from "react";
import { useParams } from "react-router-dom";
import ArticleOne from "../components/Article/ArticleOne";

import { ArticleContextProvider } from "../store/article-context";

const ArticleOnePage = () => {
  let { articleId } = useParams();

  return (
    <Fragment>
      <ArticleContextProvider>
          <ArticleOne item={articleId}/>
      </ArticleContextProvider>
    </Fragment>
  )
};

export default ArticleOnePage;