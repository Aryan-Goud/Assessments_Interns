/// reference types="cypress"

describe('Amazon', () => {
beforeEach(()=>{
  cy.visit('https://www.amazon.com/')
  cy.get('#nav-link-accountList-nav-line-1').click()
  cy.get('#ap_email').type('aryangoud9848@gmail.com')
  cy.get('#continue').click()
  cy.get('#ap_password').type('aryangoud90')
  cy.get('#signInSubmit').click()
  cy.url().should('include', 'https://www.amazon.com/')
})

  it('search for product', () => {
    // cy.visit('https://www.amazon.com/')
    cy.get('#twotabsearchtextbox').type('watches')
    cy.get('#nav-search-submit-button').click()
    cy.get('.rush-component > .a-row').click();
    cy.get('#buy-now-button').click();
    // cy.url().should('include', 'https://www.amazon.com/')
  })
  it('deleting added product', () => {

    cy.get('#nav-cart-count').click()
    cy.get('.sc-action-delete > .a-declarative > .a-color-link').click()
    // cy.url().should('include', 'https://www.amazon.com/')
  })

})