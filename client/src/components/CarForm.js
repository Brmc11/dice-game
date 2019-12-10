import React from 'react';
import Button from '@material-ui/core/Button'
import FormControl from '@material-ui/core/FormControl';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';
import TextField from '@material-ui/core/TextField';
import { withStyles } from '@material-ui/core/styles';
import './CarForm.css';

const defaultState = {
  make: '',
  model: '',
  year: '',
  radius: '',
  zipCode: '',
  error: ''
};

const styles = theme => ({
  root: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  formControl: {
    margin: theme.spacing.unit,
    minWidth: 155,
  },
  selectEmpty: {
    marginTop: theme.spacing.unit * 2,
  },
});

class CarForm extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      ...defaultState
    };

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange = field => event => {
    this.setState({
      [field]: event.target.value
    });
    console
  }

  handleSubmit(e) {
    e.preventDefault();
    const { make, model, year, radius, zipCode } = this.state;
    
    const userInput = {
      make: make.trim(),
      model: model.trim(),
      year: year.trim(), 
      radius, 
      zipCode: zipCode.trim()
    };

    if (!make || !year) {
      this.setState({ error: '**this is a required value**' });
    } else {
      this.props.handleSubmit(userInput);
      this.setState({...defaultState });
    }

  }

  render() {
    const { classes } = this.props;
    return (

      <form className='car-form' id='car-form' onSubmit={this.handleSubmit}>
        <div className="mandatory-fields">
          <div>
            <TextField
              id="standard-with-placeholder"
              label="make"
              placeholder="Make"
              className="car-form-input"
              margin="normal"
              onChange={this.handleChange('make')}
              value={this.state.make}
              />
            {this.state.error && <div className="required-field">{this.state.error}</div>}
          </div>
          <div>
            <TextField
              id="standard-with-placeholder"
              label="model"
              placeholder="Model"
              className="car-form-input"
              margin="normal"
              onChange={this.handleChange('model')}
              value={this.state.model}
              />
          </div>
          <div>
            <TextField
              id="standard-with-placeholder"
              label="year"
              placeholder="Year"
              className="car-form-input"
              margin="normal"
              onChange={this.handleChange('year')}
              value={this.state.year}
              />
            {this.state.error && <div className="required-field">{this.state.error}</div>}
          </div>
          {this.props.areNoSearchResults && <div>No Results, Please try another search</div>}
          <Button variant="contained" color="primary" type="submit">
            Search
          </Button>
        </div>
        <div className="optional-fields">
          <div>
            <TextField
              id="standard-with-placeholder"
              label="zip"
              placeholder="Zip Code"
              className="car-form-input"
              margin="normal"
              onChange={this.handleChange('zipCode')}
              value={this.state.zipCode}
            />
          </div>
          
          <FormControl className={ classes.formControl }>
            <InputLabel htmlFor="radius-simple">radius</InputLabel>
            <Select
              value={this.state.radius}
              onChange={this.handleChange('radius')}
              inputProps={{
                name: 'radius',
                id: 'radius-simple',
              }}
            >
              <MenuItem value="">
                <em>None</em>
              </MenuItem>
              <MenuItem value={10}>10</MenuItem>
              <MenuItem value={25}>25</MenuItem>
              <MenuItem value={50}>50</MenuItem>
              <MenuItem value={100}>100</MenuItem>
            </Select>
          </FormControl>
          
        </div>
      </form>
    )
  }
}

export default withStyles(styles)(CarForm);
