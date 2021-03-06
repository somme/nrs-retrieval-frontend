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

import play.api.http.Status
import play.api.test.Helpers._
import play.api.test._
import uk.gov.hmrc.play.test._

class routeSpec extends UnitSpec with WithFakeApplication {

  "routing" should {
    "return 404 NotFound for GET /" in {
      val response = await(route(fakeApplication, FakeRequest(GET, "/")).get)
      response.header.status shouldBe Status.NOT_FOUND
    }

    "return 200 Ok for GET /nrs-retrieval-frontend/search should" in {
      val response = await(route(fakeApplication, FakeRequest(GET, "/nrs-retrieval-frontend/search")).get)
      response.header.status shouldBe Status.OK
    }

    "return 200 Ok for GET /nrs-retrieval-frontend/start" in {
      val response = await(route(fakeApplication, FakeRequest(GET, "/nrs-retrieval-frontend/start")).get)
      response.header.status shouldBe Status.OK
    }
  }
}