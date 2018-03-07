/*
 * Copyright 2018 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.nrsretrievalfrontend.controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc._

import scala.concurrent.Future
import play.api.i18n.{I18nSupport, MessagesApi}
import uk.gov.hmrc.play.bootstrap.controller.FrontendController
import uk.gov.hmrc.nrsretrievalfrontend.config.AppConfig
import uk.gov.hmrc.nrsretrievalfrontend.connectors.NrsRetrievalConnector
import uk.gov.hmrc.nrsretrievalfrontend.views

@Singleton
class HelloWorld @Inject()(val messagesApi: MessagesApi,
                           val connector: NrsRetrievalConnector,
                           implicit val appConfig: AppConfig) extends FrontendController with I18nSupport {

  val helloWorld = Action.async { implicit request =>
    connector.getHelloWorld().map(t => Ok(views.html.hello_world(t.body)))
  }

}